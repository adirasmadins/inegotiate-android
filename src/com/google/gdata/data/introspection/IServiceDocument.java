package com.google.gdata.data.introspection;

import java.util.List;

public interface IServiceDocument {
    IWorkspace addWorkspace(String str);

    List<? extends IWorkspace> getWorkspaces();
}
