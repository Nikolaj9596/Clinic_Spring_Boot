package com.example.clinic.services;

import com.example.clinic.models.Client;
import com.example.clinic.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
  private final ClientRepository repository;

  public Client create(Client client) {
    return repository.save(client);
  }

  public Client update(long client_id, Client client) {
    if (!repository.existsById(client_id)) {
      throw new RuntimeException("Клиент не существует");
    }
    return repository.save(client);
  }

  public void delete(Long client_id) {
    repository.deleteById(client_id);
  }

  public Client getById(Long client_id) {
    Optional<Client> client = repository.findById(client_id);
    if (client.isPresent()) {
      throw new RuntimeException("Клиент не существует");
    }
    return client.get();
  }

  public List<Client> getAll(Integer limit, Integer offset) {
    PageRequest pageRequest = PageRequest.of(offset, limit);
    Page<Client> page = repository.findAll(pageRequest);
    return page.getContent();
  }
}
