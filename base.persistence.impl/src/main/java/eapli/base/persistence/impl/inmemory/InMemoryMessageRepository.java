package eapli.base.persistence.impl.inmemory;

import eapli.base.messagemanagement.domain.Message;
import eapli.base.messagemanagement.repositories.MessageRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryMessageRepository extends InMemoryDomainRepository<Long, Message> implements MessageRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Message> allOrderedMessages() {
        return null;
    }
}
