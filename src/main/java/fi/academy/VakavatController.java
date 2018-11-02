package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*") // Sallitaan cross-origin-pyynnöt.
@RestController
public class VakavatController {

    private VakavatRepository vakavatRepository;

    @Autowired
    public VakavatController(VakavatRepository vakavatRepository) {
        this.vakavatRepository = vakavatRepository;
    }

    @GetMapping("/vakavat/")
    public List<Vakavat> getAllMessages() {
        return vakavatRepository.findAll();
    }

    @GetMapping("/vakavat/id/{id}")
    public Vakavat getByMessageId(@PathVariable("id") int messageId) {
        return vakavatRepository.getByMessageId(messageId);
    }

    @GetMapping("/vakavat/idt/{id}")
    public List<Vakavat> getAllMessagesById(@PathVariable("id") int messageId) {
        return vakavatRepository.getAllByMessageId(messageId);
    }

    @GetMapping("/vakavat/name/{name}")
    public Vakavat getMsgByName(@PathVariable("name") String name) {
        return vakavatRepository.getMessageByName(name);
    }

    @PostMapping("/vakavat/")
    public Vakavat addNewMessage(@Valid @RequestBody Vakavat message) {
        vakavatRepository.save(message);
        return message;
    }

    @DeleteMapping("/vakavat/id/{id}")
    public void deleteTopicById(@PathVariable("id") int messageId) {
        vakavatRepository.delete(vakavatRepository.getByMessageId(messageId));
    }


    @DeleteMapping("/vakavat/name/{name}")
    public void deleteTopicByName(@PathVariable("name") String name) {
        vakavatRepository.delete(vakavatRepository.getMessageByName(name));
    }

    @PutMapping("/vakavat/id/{id}") //Luo uuden Json-olion eikä muokkaa vanhaa
    public void modifyMessageById(@PathVariable("id") int messageId, @Valid @RequestBody Vakavat message) {
        message.setMessageId(messageId);
        vakavatRepository.save(message);
    }
}
