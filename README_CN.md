
<h1 align="center">
    <p>GifSpireCard</p>
</h1>
<p align="center">
    <a href="https://github.com/sleepyHolo/SpireMod_GifSpireCard/search?l=java">
        <img alt="language" src="https://img.shields.io/github/languages/top/sleepyHolo/SpireMod_GifSpireCard">
    </a>
    <a href="https://github.com/sleepyHolo/SpireMod_GifSpireCard/blob/main/LICENSE">
        <img alt="license" src="https://img.shields.io/github/license/sleepyHolo/SpireMod_GifSpireCard">
    </a>
    <a href="https://github.com/RichardLitt/standard-readme">
        <img alt="standard-readme" src="https://img.shields.io/badge/readme%20style-standard-brightgreen">
    </a>
    <a href="https://github.com/sleepyHolo/SpireMod_GifSpireCard/wiki">
        <img alt="documentation" src="https://img.shields.io/badge/doc-wiki-red">
    </a>
</p>
<p align="center">
    <b> <a href="README.md">English</a> | 简体中文 </b>
</p>

---

# GifSpireCard
通过补丁使 `basemod.abstracts.CustomCard` 支持GIF文件作为 imgUrl 。  
  
本仓库包含以下内容：  
- GifSpireCard (GSC) ，一个用于提供GIF卡图支持的 _杀戮尖塔_ 工具模组。
- 通过覆写铁甲战士的卡牌，提供使用 GSC 的示例（已包含于 GSC 文件中）。
- Python 工具，用于创建 _杀戮尖塔_ 风格的 GIF 文件。

## 内容列表
- [背景](#背景)
- [安装和构建](#安装和构建)
- [使用](#使用)
- [GIF来源](#gif来源)
- [相关仓库](#相关仓库)
- [维护者](#维护者)
- [如何贡献](#如何贡献)
- [许可](#许可)

## 背景
GifSpireCard 最开始起源于一张 _杀戮尖塔_ 梗图，其将 _扫腿_ 的原始卡面替换为了动态猫猫。为了确认是否此前有人做过类似的模组，我搜索了 Steam 创意工坊。但正如我在 wiki 中提到的那样，我并没有在第一时间找到 [GifTheSpireLib](https://github.com/lobbienjonsji/GifTheSpire) 。  

## 安装和构建
这个项目使用 **Slay the Spire**，**ModTheSpire** 和 **BaseMod**。  
你可以在 Steam 或其他地方购买 _杀戮尖塔 (Slay the Spire)_ 游戏本体。  
- 在 [GitHub](https://github.com/kiooeht/ModTheSpire) 或 [Steam 创意工坊](https://steamcommunity.com/sharedfiles/filedetails/?id=1605060445) 下载 _ModTheSpire_ 。
- 在 [GitHub](https://github.com/daviscook477/BaseMod) 或 [Steam 创意工坊](https://steamcommunity.com/sharedfiles/filedetails/?id=1605833019) 下载 _BaseMod_。

这个项目使用 **Maven** 进行构建。你可以自行修改 `pom.xml` 来定位你的本地依赖包 (`desktop-1.0.jar`，`ModTheSpire.jar` 和 `BaseMod.jar`). [Wiki - Build](https://github.com/sleepyHolo/SpireMod_GifSpireCard/wiki#build) 可能对您有所帮助。 
### 安装
- 通过 GitHub 进行下载。
    - 下载[最新的发布包](https://github.com/sleepyHolo/SpireMod_GifSpireCard/releases/latest)。
    - 将 `GifSpireCard.jar` 移动至 `./mods/`。此路径相对于你的 _杀戮尖塔_ 安装目录。
- 通过 Steam 创意工坊进行下载。
    - 在 [Steam 创意工坊](https://steamcommunity.com/sharedfiles/filedetails/?id=3534165833) 订阅 GifSpireCard 。
    （在您启动 _杀戮尖塔_ 前， Steam 会自行为您安排此模组的安装）

## 使用
此项目可作为工具模组用于 _杀戮尖塔_ 。通过旁加载 GSC ，`basemod.abstracts.CustomCard` 将允许您使用 GIF 文件作为卡面。[Wiki - Sideload GSC](https://github.com/sleepyHolo/SpireMod_GifSpireCard/wiki/Sideload-GSC) 可能对您有所帮助。  
  
您可以利用 `gif_builder.py` 创建适合用作 _杀戮尖塔_ 卡面的 GIF 文件。[Wiki - gif_builder.py Documentation](https://github.com/sleepyHolo/SpireMod_GifSpireCard/wiki/gif_builder.py-Documentation) 可能对您有所帮助。 

## GIF来源
如无特别说明，所有 GIF 文件均来自 [GIPHY](https://giphy.com/) 。  

## 相关仓库
也许你愿意顺便看看我其他的 _杀戮尖塔_ 模组仓库？  
- [CET46InSpire](https://github.com/sleepyHolo/SpireMod_CET46InSpire) ![GitHub Stars](https://img.shields.io/github/stars/sleepyHolo/SpireMod_CET46InSpire)：一个基于 CET 和 JLPT 的简单整活模组。
- [SteamMerchant](https://github.com/sleepyHolo/SpireMod_SteamMerchant) ![GitHub Stars](https://img.shields.io/github/stars/sleepyHolo/SpireMod_SteamMerchant)：简单的 Steam 风格商人。（也就是打折）

## 维护者
[@sleepyHolo](https://github.com/sleepyHolo)

## 如何贡献
非常欢迎你的加入！[提一个 Issue](https://github.com/sleepyHolo/SpireMod_GifSpireCard/issues/new) 或者提交一个 Pull Request。  
### 我有更棒的GIF素材
如果你认为此仓库中包含的某些GIF素材并不理想，你可以提供你自己选择的素材！  
请保证您的 [Issue](https://github.com/sleepyHolo/SpireMod_GifSpireCard/issues/new) 包含以下内容： 
- 哪一张卡牌的素材不好？请尽量提供卡牌的中文或英文名。
- 你自己的GIF素材。 GitHub 支持您将大小小于 [10MB](https://docs.github.com/en/get-started/writing-on-github/working-with-advanced-formatting/attaching-files) 的 .gif 文件作为附件。  

我会通过评论的方式发表我的意见。

## 许可
[MIT](LICENSE) © HX Wang