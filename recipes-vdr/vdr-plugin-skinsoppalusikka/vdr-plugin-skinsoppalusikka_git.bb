SUMMARY = "Skin soppalusikka for VDR"
AUTHOR = "Rolf Ahrenberg"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r0"

SRC_URI = "git://github.com/rofafor/vdr-plugin-skinsoppalusikka.git"
SRCREV  = "0514a3f596b1d773fdf2635d65c9e109d05111ff"

S = "${WORKDIR}/git"

inherit pkgconfig gettext

DEPENDS = "vdr vdr-font-symbols"

CXXFLAGS_append = " -fPIC -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

EXTRA_OEMAKE = ' STRIP=/bin/true '

do_install() {
	oe_runmake DESTDIR=${D} install

	install -d ${D}${sysconfdir}/vdr/themes
	install -m 0755 ${S}/themes/*.theme ${D}${sysconfdir}/vdr/themes
	
	install -d ${D}/etc/vdr/plugins/skinsoppalusikka/logos
	install -m 0755 ${S}/symbols/*.xpm ${D}/etc/vdr/plugins/skinsoppalusikka/logos	
}

FILES_${PN} += " \
	${libdir}/vdr/* \
	${sysconfdir}/vdr/themes/* \
	${sysconfdir}/vdr/skinsoppalusikka/logos/* \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"

