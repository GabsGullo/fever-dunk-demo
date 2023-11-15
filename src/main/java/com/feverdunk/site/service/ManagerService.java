package com.feverdunk.site.service;

//import com.feverdunk.site.exceptions.AuthorizationException;
import com.feverdunk.site.exceptions.ObjectNotFoundException;
import com.feverdunk.site.models.Manager;
import com.feverdunk.site.models.Perfil;
import com.feverdunk.site.repository.ManagerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    public List<Manager> getManager() {
        return this.managerRepository.findAll();
    }

    public Manager findById(Long id) {

            Optional<Manager> manager = this.managerRepository.findById(id);
            return manager.orElseThrow(() -> {return new ObjectNotFoundException("Manager com id: {" + id + "} não foi encontrado");});
    }

    public Manager create(Manager manager) {
        manager.setId(null);
        manager.setSenha(manager.getSenha());
        return this.managerRepository.save(manager);
    }

    public Manager update(Manager managerNovo) {
        Manager manager = this.findById(managerNovo.getId());
        manager.setDinheiro(managerNovo.getDinheiro());
        manager.setEmail(managerNovo.getEmail());
        manager.setNome(managerNovo.getNome());
        manager.setSenha(managerNovo.getSenha());
        manager.setSenha(managerNovo.getSenha());
        manager.setPremium(managerNovo.isPremium());
        manager.setTime(managerNovo.getTime());
        manager.setPerfis(Stream.of(Perfil.USER.getCodigo()).collect(Collectors.toSet()));
        return this.managerRepository.save(manager);
    }

    public void delete(Long id) {
        this.managerRepository.delete(this.findById(id));
    }
}
