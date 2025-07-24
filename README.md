
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
    <b> English | <a href="README_CN.md">简体中文</a> </b>
</p>

---

# GifSpireCard
Make `basemod.abstracts.CustomCard` support .gif files as imgUrl by patching it.  
  
This repository contains:  
- a _Slay the Spire_ mod GifSpireCard (GSC), a tool mod supports GIF card images.
- an example to use GSC, overriding Ironclad's cards (in GSC).
- a tool for creating GIF images as _STS_ style based on Python.

## Table of Contents
- [Background](#background)
- [Install & Build](#install--build)
- [Usage](#usage)
- [GIF Source](#gif-source)
- [Related Efforts](#related-efforts)
- [Maintainers](#maintainers)
- [Contributing](#contributing)
- [License](#license)

## Background
GifSpireCard started with a _Slay the Spire_ meme, where the original image of _Leg Sweep_ was replaced with a cat gif. I searched on Steam workshop (to find whether someone else has done mod like this), but just as I mentioned in the wiki, I have not found [GifTheSpireLib](https://github.com/lobbienjonsji/GifTheSpire) at that time.  

## Install & Build
This project uses **Slay the Spire**, **ModTheSpire** and **BaseMod**.  
You can buy _Slay the Spire_ on Steam or anywhere. 
- Download _ModTheSpire_ from [GitHub](https://github.com/kiooeht/ModTheSpire) or [Steam workshop](https://steamcommunity.com/sharedfiles/filedetails/?id=1605060445).
- Download _BaseMod_ from [GitHub](https://github.com/daviscook477/BaseMod) or [Steam workshop](https://steamcommunity.com/sharedfiles/filedetails/?id=1605833019).

This project uses **Maven** to build. You can modify `pom.xml` to point to your local dependencies (`desktop-1.0.jar`, `ModTheSpire.jar` and `BaseMod.jar`). [Wiki - Build](https://github.com/sleepyHolo/SpireMod_GifSpireCard/wiki#build) may help.
### Installation
**The mod for this repository has not been released yet.**
- Download from GitHub.
    - Download the latest Release.
    - Move `GifSpireCard.jar` to `./mods/` relative to your _Slay the Spire_ install directory.
- Download from Steam workshop.
    - Subscribe GifSpireCard on Steam workshop.
    (Steam will install GifSpireCard before running _Slay the Spire_)

## Usage
This project can be used as a tool mod for _Slay the Spire_. GIF files can be given as imgUrl for `basemod.abstracts.CustomCard` via sideloading GSC. [Wiki - Sideload GSC](https://github.com/sleepyHolo/SpireMod_GifSpireCard/wiki/Sideload-GSC) may help.  
  
You can create GIFs for _Slay the Spire_ cards with `gif_builder.py`. [Wiki - gif_builder.py Documentation](https://github.com/sleepyHolo/SpireMod_GifSpireCard/wiki/gif_builder.py-Documentation) may help.

## GIF Source
Unless otherwise noted, all GIFs are from [GIPHY](https://giphy.com/).  

## Related Efforts
Maybe you would give my other _Slay the Spire_ mod repositories a look?
- [CET46InSpire](https://github.com/sleepyHolo/SpireMod_CET46InSpire) ![GitHub Stars](https://img.shields.io/github/stars/sleepyHolo/SpireMod_CET46InSpire): a simple funny mod based on Chinese CET and JLPT.
- [SteamMerchant](https://github.com/sleepyHolo/SpireMod_SteamMerchant) ![GitHub Stars](https://img.shields.io/github/stars/sleepyHolo/SpireMod_SteamMerchant): a simple Steam-style merchant. (namely discount)

## Maintainers
[@sleepyHolo](https://github.com/sleepyHolo)

## Contributing
Feel free to dive in! [Open an issue](https://github.com/sleepyHolo/SpireMod_GifSpireCard/issues/new) or submit PRs.  
### I have better GIF
If you think GIFs in this repository are not good, you can offer your own GIFs!  
Please [open an issue](https://github.com/sleepyHolo/SpireMod_GifSpireCard/issues/new) with:  
- which card you want to replace, better in English or Chinese.
- your .gif file. GitHub allows you to attach .gif files under [10MB](https://docs.github.com/en/get-started/writing-on-github/working-with-advanced-formatting/attaching-files).  

I will write my opinion with a comment.

## License
[MIT](LICENSE) © HX Wang