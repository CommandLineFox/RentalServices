package com.example.service.user.service.impl;

import com.example.service.user.domain.Manager;
import com.example.service.user.dto.CreateManagerDto;
import com.example.service.user.dto.ManagerDto;
import com.example.service.user.dto.TokenRequestDto;
import com.example.service.user.dto.TokenResponseDto;
import com.example.service.user.exception.NotFoundException;
import com.example.service.user.listener.helper.MessageHelper;
import com.example.service.user.mapper.ManagerMapper;
import com.example.service.user.repository.ManagerRepository;
import com.example.service.user.security.service.TokenService;
import com.example.service.user.service.ManagerService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    private final ManagerMapper managerMapper;
    private final ManagerRepository managerRepository;
    private final TokenService tokenService;
    private MessageHelper messageHelper;
    private String orderDestination;
    //private JmsTemplate jmsTemplate;

    public ManagerServiceImpl(ManagerMapper managerMapper, ManagerRepository managerRepository,
                              TokenService tokenService, @Value("${destination.createOrder}") String orderDestination) {
        this.managerMapper = managerMapper;
        this.managerRepository = managerRepository;
        this.tokenService = tokenService;
        this.orderDestination = orderDestination;
    }

    @Override
    public List<ManagerDto> nadjiSveManagere() {
        return null;
    }

    @Override
    public ManagerDto nadjiManagera(String id) {
        return null;
    }

    @Override
    public ManagerDto dodajManagera(CreateManagerDto createManagerDto) {
        Manager manager = managerMapper.createManagerDtoToManager(createManagerDto);
        managerRepository.save(manager);
        return managerMapper.managerToManagerDto(manager);
    }

    @Override
    public ManagerDto azurirajManagera(ManagerDto managerDto) {
        Manager manager = managerRepository.getOne((long) managerDto.getManagerId());

        if (managerDto.getUsername() == null)
            manager.setUsername(managerDto.getUsername());
        if (managerDto.getPassword() == null)
            manager.setPassword(managerDto.getPassword());
        if (managerDto.getMail() == null)
            manager.setMail(managerDto.getMail());
        if (managerDto.getPhoneNumber() == null)
            manager.setPhoneNumber(managerDto.getPhoneNumber());
        if (managerDto.getDateOfBirth() == null)
            manager.setDateOfBirth(managerDto.getDateOfBirth());
        if (managerDto.getName() == null)
            manager.setName(managerDto.getName());
        if (managerDto.getSurname() == null)
            manager.setSurname(managerDto.getSurname());
        if (managerDto.getCompanyName() == null)
            manager.setCompanyName(managerDto.getCompanyName());
        if (managerDto.getEmploymentDate() == null)
            manager.setEmploymentDate(managerDto.getEmploymentDate());

        managerRepository.save(manager);
        return managerMapper.managerToManagerDto(manager);
    }

    @Override
    public ManagerDto banujManagera(String id) {

        Manager manager = managerRepository.getOne(Long.valueOf(id));
        manager.setZabrana(true);
        managerRepository.save(manager);
        return managerMapper.managerToManagerDto(manager);
    }

    @Override
    public ManagerDto unbanujManagera(String id) {

        Manager manager = managerRepository.getOne(Long.valueOf(id));
        manager.setZabrana(false);
        managerRepository.save(manager);
        return managerMapper.managerToManagerDto(manager);
    }

    @Override
    public void order(Long id, Integer count) {
        //  CreateOrderDto orderCreateDto = new CreateOrderDto(count, id);
        // jmsTemplate.convertAndSend(orderDestination, messageHelper.createTextMessage(orderCreateDto));
    }

    @Override
    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        //Try to find active user for specified credentials
        try {
            Manager manager = managerRepository
                    .findManagerByUsernameAndPassword(tokenRequestDto.getUsername(), tokenRequestDto.getPassword())
                    .orElseThrow(() -> new NotFoundException(String
                            .format("User with username: %s and password: %s not found.", tokenRequestDto.getUsername(),
                                    tokenRequestDto.getPassword())));
            //Create token payload
            Claims claims = Jwts.claims();
            claims.put("id", manager.getManagerId());
            claims.put("role", "ROLE_MANAGER");

            //Generate token
            return new TokenResponseDto(tokenService.generate(claims));
        } catch (Exception e) {
            return null;
        }

    }


}
