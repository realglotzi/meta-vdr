SUMMARY = "This is a TrueType font that includes the symbols used by some VDR plugins and patches, e.g. ExtRecMenu v1.2test1, NordlichtsEPG v0.9test1, EPGsearch v0.9.24beta26, Music plugin and zulu's VDR Extensions Patch v56."
LICENSE = "GPLv2"
AUTHOR = "Andreas Mair"
LIC_FILES_CHKSUM = "file://COPYRIGHT.txt;md5=9f867da7a73fad2715291348e80d0763"

SRC_URI = "http://andreas.vdr-developer.org/fonts/download/vdrsymbols-ttf-20100612.tgz"

SRC_URI[md5sum] = "dad98a1cdb2b7deb3301ecf46181d258"                                                                                                                                                               
SRC_URI[sha256sum] = "63107e25c0e4b5ae5aadef8e4323ff58a0cbd2f965827d26dba6d4f664370bf4"  

S = "${WORKDIR}/vdrsymbols"

do_install() {
	install -d ${D}/usr/share/fonts/ttf/	
	install -m 0755 ${S}/VDRSymbolsSans-Bold.ttf ${D}/usr/share/fonts/ttf/
	install -m 0755 ${S}/VDRSymbolsSans.ttf      ${D}/usr/share/fonts/ttf/
}

FILES_${PN} += "${datadir}/fonts/ttf/*.ttf"


