package eapli.base.messagemanagement.repositories;

import eapli.base.messagemanagement.domain.Message;
import eapli.framework.domain.repositories.DomainRepository;

public interface MessageRepository extends DomainRepository<Long, Message> {
    Iterable<Message> allOrderedMessages();
}
