package com.ark.infrastructure.base;

import com.ark.domain.AbstractEntity;

public interface Convertor<D extends AbstractEntity, P extends AbstractPersistent> {
    P getPOInstance();

    default P DOToPO(D DO) {
        P poInstance = getPOInstance();
        poInstance.id = DO.getId();
        poInstance.creator = DO.getCreator();
        poInstance.modifier = DO.getModifier();
        poInstance.createdDateTime = DO.getCreatedDateTime();
        poInstance.modifiedDateTime = DO.getModifiedDateTime();
        doDOToPO(poInstance, DO);
        return poInstance;
    };

    P doDOToPO(P PO, D DO);

    D POToDO(P PO);
}
