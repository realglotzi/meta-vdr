SUMMARY = "VDR skinenigmang plugin"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCREV = "73b31166140d84bff88152ed99442ea24f3d6052"
SRC_URI = "git://projects.vdr-developer.org/vdr-plugin-skinenigmang.git \
           file://vdr-skinenigmang-makefile.patch \
          "

PR="r5"

S = "${WORKDIR}/git"

inherit pkgconfig gettext

ASNEEDED = ""

DEPENDS = " \
	freetype \
	imagemagick6 \
	vdr \
	vdr-font-symbols \
"

EXTRA_OEMAKE = "DESTDIR=\"${D}\" 'INCLUDES=-I${STAGING_INCDIR}/freetype2 -I${STAGING_INCDIR}/ImageMagick-6 -I${S}' LIBS=-L${STAGING_LIBDIR} HAVE_IMAGEMAGICK=1"

do_install() {
	oe_runmake DESTDIR=${D} install
}

FILES_${PN} = " \
	${libdir}/vdr/* \
	${sysconfdir}/vdr/themes/* \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"
