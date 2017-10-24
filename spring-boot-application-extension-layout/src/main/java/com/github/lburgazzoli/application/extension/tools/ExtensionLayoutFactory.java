package com.github.lburgazzoli.application.extension.tools;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.loader.tools.Layout;
import org.springframework.boot.loader.tools.LayoutFactory;
import org.springframework.boot.loader.tools.LibraryScope;

public class ExtensionLayoutFactory implements LayoutFactory {
    private static final Set<LibraryScope> LIB_DESTINATION_SCOPES = new HashSet<>(
        Arrays.asList(
            LibraryScope.COMPILE,
            LibraryScope.RUNTIME,
            LibraryScope.CUSTOM)
    );

    public ExtensionLayoutFactory() {
    }

    @Override
    public Layout getLayout(File file) {
        return new Layout() {
            @Override
            public String getLauncherClassName() {
                return null;
            }

            @Override
            public String getLibraryDestination(String libraryName, LibraryScope scope) {
                if (LIB_DESTINATION_SCOPES.contains(scope)) {
                    return "lib/";
                }

                return null;
            }

            @Override
            public String getClassesLocation() {
                return null;
            }

            @Override
            public boolean isExecutable() {
                return false;
            }
        };
    }
}
