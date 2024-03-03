package nl.cms.infra.database.envers;

import org.hibernate.envers.RevisionListener;

public class CMSRevisionEntityListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        CMSRevisionEntity cmsRevisionEntity = (CMSRevisionEntity) revisionEntity;
        cmsRevisionEntity.username = "username";
        cmsRevisionEntity.notes = "notes";
    }
}
