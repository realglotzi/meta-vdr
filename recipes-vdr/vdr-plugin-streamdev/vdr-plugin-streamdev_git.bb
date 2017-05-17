SUMMARY = "VDR streamdev plugin"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCREV = "84c6f6b6f363549e88efd01d12df35ae6e336578"
SRC_URI = "git://projects.vdr-developer.org/vdr-plugin-streamdev.git"

PR="r3"

S = "${WORKDIR}/git"

inherit pkgconfig gettext

DEPENDS = " vdr "

CFLAGS += "-fPIC -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

EXTRA_OEMAKE = ' \
	CFLAGS="${CFLAGS}" \
'

do_install() {
	oe_runmake DESTDIR=${D} LIBDIR=/usr/lib/vdr install
}

FILES_${PN} = " \
	${libdir}/vdr/* \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"
