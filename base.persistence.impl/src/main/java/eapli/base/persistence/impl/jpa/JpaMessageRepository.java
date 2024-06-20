package eapli.base.persistence.impl.jpa;

import eapli.base.machinemanagement.domain.ID;
import eapli.base.messagemanagement.domain.Message;
import eapli.base.messagemanagement.repositories.MessageRepository;

import javax.management.Query;
import javax.persistence.TypedQuery;

public class JpaMessageRepository extends BasepaRepositoryBase<Message, Long, Long> implements
        MessageRepository {

    public JpaMessageRepository() {
        super("id");
    }

    @Override
    public Iterable<Message> allOrderedMessages() {
        final TypedQuery<Message>query = entityManager().createQuery("SELECT m FROM Message m ORDER BY CURRENT_DATE ", Message.class);
        return query.getResultList();
    }
}
