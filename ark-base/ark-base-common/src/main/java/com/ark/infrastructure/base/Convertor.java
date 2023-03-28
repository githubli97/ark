package com.ark.infrastructure.base;

import com.ark.domain.AbstractEntity;

public interface Convertor<D extends AbstractEntity, P extends AbstractPersistent> {
    P getPOInstance();

    default P DOToPO(D DO) {
        P poInstance = getPOInstance();
        poInstance.id = DO.getId();
        poInstance.creator = DO.getCreator();
        poInstance.modifier = DO.getModifier();
        poInstance.createdTime = DO.getCreatedTime();
        poInstance.modifiedTime = DO.getModifiedTime();
        poInstance.isDeleted = false;
        poInstance.version = DO.getVersion();
        doDOToPO(poInstance, DO);
        return poInstance;
    };

    P doDOToPO(P PO, D DO);

    D POToDO(P PO);
}
