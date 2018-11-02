package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*") // Sallitaan cross-origin-pyynnöt.
@RestController
public class MessageController {

    private MessagesRepository messagesRepository;

    @Autowired
    public MessageController (MessagesRepository messagesRepository){
        this.messagesRepository=messagesRepository;
    }

    @GetMapping("/")
    public List<Message> getAllMessages(){
        return messagesRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Message getByMessageId(@PathVariable("id") int messageId) {
        return messagesRepository.getByMessageId(messageId);
    }

    @GetMapping("/idt/{id}")
    public List<Message> getAllMessagesById(@PathVariable("id") int messageId) {
        return messagesRepository.getAllByMessageId(messageId);
    }

    @GetMapping("/name/{name}")
    public Message getMsgByName(@PathVariable("name") String name) {
        return messagesRepository.getMessageByName(name);
    }

    @PostMapping("/")
    public Message addNewMessage(@Valid @RequestBody Message message){
        messagesRepository.save(message);

        return message;
    }

    @DeleteMapping("/id/{id}")
    public void deleteTopicById(@PathVariable("id") int messageId) {
        messagesRepository.delete(messagesRepository.getByMessageId(messageId));
    }


    @DeleteMapping("/name/{name}")
    public void deleteTopicByName(@PathVariable("name") String name) {
        messagesRepository.delete(messagesRepository.getMessageByName(name));
    }

    @PutMapping("/id/{id}") //Luo uuden Json-olion eikä muokkaa vanhaa
    public void modifyMessageById(@PathVariable("id") int messageId, @Valid @RequestBody Message message) {
        message.setMessageId(messageId);
        messagesRepository.save(message);
    }

}
