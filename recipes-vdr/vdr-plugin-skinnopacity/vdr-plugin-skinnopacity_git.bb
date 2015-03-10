SUMMARY = "VDR skinnopacity plugin"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRCREV = "f593ad572046998285e01ee0f5f767f88e25a94a"
SRC_URI = "git://projects.vdr-developer.org/skin-nopacity.git \
          "

PR="r0"

S = "${WORKDIR}/git"

ASNEEDED = ""

DEPENDS = " \
	freetype \
	imagemagick \
	vdr \
	vdr-font-symbols \
"

CXXFLAGS_append = " -fPIC -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

do_install() {
	oe_runmake DESTDIR=${D} install
}

FILES_${PN} = " \
	${libdir}/vdr/* \
	${sysconfdir}/vdr/themes/* \
	${sysconfdir}/vdr/plugins/skinnopacity/* \
	${datadir}/vdr/plugins/skinnopacity/* \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"
