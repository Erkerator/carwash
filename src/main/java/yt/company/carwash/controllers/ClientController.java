package yt.company.carwash.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yt.company.carwash.models.City;
import yt.company.carwash.models.Client;
import yt.company.carwash.services.ClientService;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    @GetMapping(value = "{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.accepted().build();
    }
    @PostMapping(value = "/create{id}")
    public ResponseEntity<Object> createClient(@RequestParam String name,
                                               @RequestParam String surname,
                                               @RequestParam String phone,
                                               @RequestParam Long cityId,
                                               @PathVariable(name ="id") Long userId) {
        return ResponseEntity.ok(clientService.createClient(name,surname,phone, cityId, userId));
    }
   /* @PutMapping(value = "/update")
    public ResponseEntity<?> updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
    }*/

}