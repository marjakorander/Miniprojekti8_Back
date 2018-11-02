package fi.academy;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface KevyetRepository extends MongoRepository<Kevyet, String> {

        Kevyet getByMessageId(int messageId);
        Kevyet getMessageByName(String name);
        List<Kevyet> getAllByMessageId(int messageId);

}
