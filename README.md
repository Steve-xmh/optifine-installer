# Optifine Installer

一个可安装几乎所有 1.7.2+ Optifine 的命令行安装器模块，支持指定安装的版本名称，可以用于启动器的 Optifine 安装自动化。

## 使用方式

使用 Java 携带 Optifine 原版安装文件和安装器本体，传入两个参数后运行即可。

第一个参数指定一个指向 `.minecraft` 文件夹的路径

第二个参数则是版本的名称。

```bash
java -cp "optifine.jar:optifine-installer.jar" net.stevexmh.OptifineInstaller ".minecraft" "version-name"
```

## 流程细节笔记

### Optifine 版本大概安装流程

```
copyMinecraftVersion(mcVer, mcVerOf, dirMcVers); // 全版本
installOptiFineLibrary(mcVer, ofEd, dirMcLib, false); // 全版本
installLaunchwrapperLibrary(mcVer, ofEd, dirMcLib); // 自 1.12.2？
updateJson(dirMcVers, mcVerOf, dirMcLib, mcVer, ofEd); // 全版本
updateLauncherJson(dirMc, mcVerOf);
updateLauncherStateJson(dirMc, mcVerOf); // 1.12.2
```

### 1.7.10

```
copyMinecraftVersion(mcVer, mcVerOf, dirMcVers);
installOptiFineLibrary(mcVer, ofEd, dirMcLib, false);
updateJson(dirMcVers, mcVerOf, dirMcLib, mcVer, ofEd);
updateLauncherJson(dirMc, mcVerOf);
```

### 1.12.2

```
copyMinecraftVersion(mcVer, mcVerOf, dirMcVers);
installOptiFineLibrary(mcVer, ofEd, dirMcLib, false);
installLaunchwrapperLibrary(mcVer, ofEd, dirMcLib);
updateJson(dirMcVers, mcVerOf, dirMcLib, mcVer, ofEd);
updateLauncherJson(dirMc, mcVerOf);
updateLauncherStateJson(dirMc, mcVerOf);
```

### 1.16.5

```
copyMinecraftVersion(mcVer, mcVerOf, dirMcVers);
installOptiFineLibrary(mcVer, ofEd, dirMcLib, false);
installLaunchwrapperLibrary(mcVer, ofEd, dirMcLib);
updateJson(dirMcVers, mcVerOf, dirMcLib, mcVer, ofEd);
updateLauncherJson(dirMc, mcVerOf);
```

### 1.18.2

```
copyMinecraftVersion(mcVer, mcVerOf, dirMcVers);
installOptiFineLibrary(mcVer, ofEd, dirMcLib, false);
installLaunchwrapperLibrary(mcVer, ofEd, dirMcLib);
updateJson(dirMcVers, mcVerOf, dirMcLib, mcVer, ofEd);
updateLauncherJson(dirMc, mcVerOf);
```

### 1.19

```
copyMinecraftVersion(mcVer, mcVerOf, dirMcVers);
installOptiFineLibrary(mcVer, ofEd, dirMcLib, false);
installLaunchwrapperLibrary(mcVer, ofEd, dirMcLib);
updateJson(dirMcVers, mcVerOf, dirMcLib, mcVer, ofEd);
updateLauncherJson(dirMc, mcVerOf);
```
