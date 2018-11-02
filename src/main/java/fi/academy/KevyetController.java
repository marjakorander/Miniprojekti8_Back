package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*") // Sallitaan cross-origin-pyynnöt.
@RestController
public class KevyetController {

    private KevyetRepository kevyetRepository;

    @Autowired
    public KevyetController(KevyetRepository kevyetRepository) {
        this.kevyetRepository = kevyetRepository;
    }

    @GetMapping("/kevyet/")
    public List<Kevyet> getAllMessages() {
        return kevyetRepository.findAll();
    }

    @GetMapping("/kevyet/id/{id}")
    public Kevyet getByMessageId(@PathVariable("id") int messageId) {
        return kevyetRepository.getByMessageId(messageId);
    }

    @GetMapping("/kevyet/idt/{id}")
    public List<Kevyet> getAllMessagesById(@PathVariable("id") int messageId) {
        return kevyetRepository.getAllByMessageId(messageId);
    }

    @GetMapping("/kevyet/name/{name}")
    public Kevyet getMsgByName(@PathVariable("name") String name) {
        return kevyetRepository.getMessageByName(name);
    }

    @PostMapping("/kevyet/")
    public Kevyet addNewMessage(@Valid @RequestBody Kevyet message) {
        kevyetRepository.save(message);
        return message;
    }

    @DeleteMapping("/kevyet/id/{id}")
    public void deleteTopicById(@PathVariable("id") int messageId) {
        kevyetRepository.delete(kevyetRepository.getByMessageId(messageId));
    }


    @DeleteMapping("/kevyet/name/{name}")
    public void deleteTopicByName(@PathVariable("name") String name) {
        kevyetRepository.delete(kevyetRepository.getMessageByName(name));
    }

    @PutMapping("/kevyet/id/{id}") //Luo uuden Json-olion eikä muokkaa vanhaa
    public void modifyMessageById(@PathVariable("id") int messageId, @Valid @RequestBody Kevyet message) {
        message.setMessageId(messageId);
        kevyetRepository.save(message);
    }
}
