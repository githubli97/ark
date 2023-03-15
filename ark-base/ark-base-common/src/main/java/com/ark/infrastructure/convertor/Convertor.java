package com.ark.infrastructure.convertor;

public interface Convertor<D, P> {
    P DOToPO(D DO);

    D POToDO(P PO);
}
