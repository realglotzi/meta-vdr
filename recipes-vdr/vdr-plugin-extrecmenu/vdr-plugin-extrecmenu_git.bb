SUMMARY = "VDR extrecmenu plugin"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRCREV = "c10ed8ab9894bc3e601091f005f24338c525939d"
SRC_URI = "git://projects.vdr-developer.org/vdr-plugin-extrecmenu.git \
           file://vdr-extrec-makefile.patch \
          "

PR="r2"

S = "${WORKDIR}/git"

ASNEEDED = ""

DEPENDS = " \
	vdr \
    vdr-font-symbols \
"

CXXFLAGS_append = " -fPIC -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

EXTRA_OEMAKE = ' \
	SDKSTAGE="${STAGING_DIR_HOST}" \
'

do_install() {
	oe_runmake DESTDIR=${D} install
}

FILES_${PN} = " \
	${libdir}/vdr/* \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"
