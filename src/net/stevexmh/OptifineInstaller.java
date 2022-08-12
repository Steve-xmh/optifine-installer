package net.stevexmh;

import optifine.Installer;
import optifine.Utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OptifineInstaller {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        File dirMc = new File(args[0]);
        File dirMcLib = new File(dirMc, "libraries");
        File dirMcVers = new File(dirMc, "versions");

        String ofVer = Installer.getOptiFineVersion();
        String[] ofVers = Utils.tokenize(ofVer, "_");
        String mcVer = ofVers[1];
        String ofEd = Installer.getOptiFineEdition(ofVers);
        String mcVerOf = args[1];

        Method curMethod = tryGetMethod("copyMinecraftVersion", String.class, String.class, File.class);
        if (curMethod != null) {
            curMethod.invoke(Installer.class, mcVer, mcVerOf, dirMcVers);
        }

        curMethod = tryGetMethod("installOptiFineLibrary", String.class, String.class, File.class, boolean.class);
        if (curMethod != null) {
            curMethod.invoke(Installer.class, mcVer, ofEd, dirMcLib, false);
        }

        curMethod = tryGetMethod("installLaunchwrapperLibrary", String.class, String.class, File.class);
        if (curMethod != null) {
            curMethod.invoke(Installer.class, mcVer, ofEd, dirMcLib);
        }

        curMethod = tryGetMethod("updateJson", File.class, String.class, File.class, String.class, String.class);
        if (curMethod != null) {
            curMethod.invoke(Installer.class, dirMcVers, mcVerOf, dirMcLib, mcVer, ofEd);
        }

        curMethod = tryGetMethod("updateLauncherJson", File.class, String.class);
        if (curMethod != null) {
            curMethod.invoke(Installer.class, dirMc, mcVerOf);
        }

        curMethod = tryGetMethod("updateLauncherStateJson", File.class, String.class);
        if (curMethod != null) {
            curMethod.invoke(Installer.class, dirMc, mcVerOf);
        }
    }

    private static Method tryGetMethod(String methodName, Class<?>... parameterTypes) {
        try {
            Method method = Installer.class.getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);
            return method;
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
}
