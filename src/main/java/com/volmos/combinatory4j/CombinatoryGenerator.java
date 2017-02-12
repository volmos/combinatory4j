package com.volmos.combinatory4j;

import java.util.Collection;

public interface CombinatoryGenerator<T, N extends Collection<T>, P extends Collection<T>> {

    void setElements(N elements);

    void generate(CombinatoryCallback<T, P> callback);

}
