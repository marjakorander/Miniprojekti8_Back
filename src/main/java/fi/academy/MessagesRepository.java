package fi.academy;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessagesRepository extends MongoRepository<Message, String> {

    Message getByMessageId(int messageId);
    Message getMessageByName(String name);
    List<Message> getAllByMessageId(int messageId);

}
