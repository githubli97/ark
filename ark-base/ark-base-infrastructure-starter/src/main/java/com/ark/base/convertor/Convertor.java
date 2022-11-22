package com.ark.base.convertor;

public interface Convertor<D, P> {
    P DOToPO(D DO);

    D POToDO(P PO);
}
