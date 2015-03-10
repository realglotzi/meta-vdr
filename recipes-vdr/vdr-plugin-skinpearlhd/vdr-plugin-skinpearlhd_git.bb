SUMMARY = "VDR skinpearlhd plugin"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRCREV = "9899940a4920e77d1d6c14a3b1bb16be47f5045d"
SRC_URI = "git://projects.vdr-developer.org/vdr-plugin-skinpearlhd.git \
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

EXTRA_OEMAKE = "DESTDIR=\"${D}\" 'INCLUDES=-I${STAGING_INCDIR}/freetype2 -I${STAGING_INCDIR}/ImageMagick-6 -I${S}' LIBS=-L${STAGING_LIBDIR} 'LDFLAGS=-lfreetype -lMagick++-6.Q16' "

do_install() {
	oe_runmake DESTDIR=${D} install
}

FILES_${PN} = " \
	${libdir}/vdr/* \
	${sysconfdir}/vdr/themes/* \
	${sysconfdir}/vdr/plugins/skinpearlhd/* \
	${datadir}/vdr/plugins/skinpearlhd/* \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"
