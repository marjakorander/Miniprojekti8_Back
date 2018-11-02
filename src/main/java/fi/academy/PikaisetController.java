package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*") // Sallitaan cross-origin-pyynnöt.
@RestController
public class PikaisetController {

    private PikaisetRepository pikaisetRepository;

    @Autowired
    public PikaisetController(PikaisetRepository pikaisetRepository) {
        this.pikaisetRepository = pikaisetRepository;
    }

    @GetMapping("/pikaiset/")
    public List<Pikaiset> getAllMessages() {
        return pikaisetRepository.findAll();
    }

    @GetMapping("/pikaiset/id/{id}")
    public Pikaiset getByMessageId(@PathVariable("id") int messageId) {
        return pikaisetRepository.getByMessageId(messageId);
    }

    @GetMapping("/pikaiset/idt/{id}")
    public List<Pikaiset> getAllMessagesById(@PathVariable("id") int messageId) {
        return pikaisetRepository.getAllByMessageId(messageId);
    }

    @GetMapping("/pikaiset/name/{name}")
    public Pikaiset getMsgByName(@PathVariable("name") String name) {
        return pikaisetRepository.getMessageByName(name);
    }

    @PostMapping("/pikaiset/")
    public Pikaiset addNewMessage(@Valid @RequestBody Pikaiset message) {
        pikaisetRepository.save(message);
        return message;
    }

    @DeleteMapping("/pikaiset/id/{id}")
    public void deleteTopicById(@PathVariable("id") int messageId) {
        pikaisetRepository.delete(pikaisetRepository.getByMessageId(messageId));
    }


    @DeleteMapping("/pikaiset/name/{name}")
    public void deleteTopicByName(@PathVariable("name") String name) {
        pikaisetRepository.delete(pikaisetRepository.getMessageByName(name));
    }

    @PutMapping("/pikaiset/id/{id}") //Luo uuden Json-olion eikä muokkaa vanhaa
    public void modifyMessageById(@PathVariable("id") int messageId, @Valid @RequestBody Pikaiset message) {
        message.setMessageId(messageId);
        pikaisetRepository.save(message);
    }
}
