package nl.cms.infra.database.envers;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public interface CMSRepository<E> extends PanacheRepositoryBase<E, Long> {
}
