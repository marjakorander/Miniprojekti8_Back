package fi.academy;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PikaisetRepository extends MongoRepository<Pikaiset, String> {

    Pikaiset getByMessageId(int messageId);
    Pikaiset getMessageByName(String name);
    List<Pikaiset> getAllByMessageId(int messageId);

}