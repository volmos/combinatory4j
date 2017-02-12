package com.volmos.combinatory4j;

import java.util.Collection;

public interface CombinatoryCallback<T, N extends Collection<T>> {

    void onNewGroup(N group);

}
