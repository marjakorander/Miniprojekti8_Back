package fi.academy;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VakavatRepository extends MongoRepository<Vakavat, String> {

    Vakavat getByMessageId(int messageId);
    Vakavat getMessageByName(String name);
    List<Vakavat> getAllByMessageId(int messageId);

}