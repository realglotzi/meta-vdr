SUMMARY = "VDR skinenigmang plugin hires logo pack"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;md5=28ba3a170bb1f6635282ec0499c77cb0"

SRCREV = "73b31166140d84bff88152ed99442ea24f3d6052"
SRC_URI = "http://andreas.vdr-developer.org/enigmang/download/skinenigmang-logos-xpm-hi-20070702.tgz"

SRC_URI[md5sum] = "736483b8d94c04f5dce5d99ebb3a3bf1"
SRC_URI[sha256sum] = "3428569d284db2fb1e57fe2683a818be489311d0b0ca3d4d172d34638fa61eaf"

PR="r0"

S = "${WORKDIR}/skinenigmang"

ASNEEDED = ""

DEPENDS = "vdr-plugin-skinenigmang"

do_install() {
	install -d ${D}/etc/vdr/plugins/skinenigmang/flags
	install -m 0755 ${S}/flags/*.xpm ${D}/etc/vdr/plugins/skinenigmang/flags
	
	install -d ${D}/etc/vdr/plugins/skinenigmang/icons/audio
	install -m 0755 ${S}/icons/audio/*.xpm ${D}/etc/vdr/plugins/skinenigmang/icons/audio

	install -d ${D}/etc/vdr/plugins/skinenigmang/icons/menu
	install -m 0755 ${S}/icons/menu/*.xpm ${D}/etc/vdr/plugins/skinenigmang/icons/menu
	
	install -d ${D}/etc/vdr/plugins/skinenigmang/icons/message
	install -m 0755 ${S}/icons/message/*.xpm ${D}/etc/vdr/plugins/skinenigmang/icons/message
	
	install -d ${D}/etc/vdr/plugins/skinenigmang/icons/replay
	install -m 0755 ${S}/icons/replay/*.xpm ${D}/etc/vdr/plugins/skinenigmang/icons/replay

	install -d ${D}/etc/vdr/plugins/skinenigmang/icons/volume
	install -m 0755 ${S}/icons/volume/*.xpm ${D}/etc/vdr/plugins/skinenigmang/icons/volume

}

FILES_${PN} = " \
	${sysconfdir}/vdr/plugins/skinenigmang/* \
"
