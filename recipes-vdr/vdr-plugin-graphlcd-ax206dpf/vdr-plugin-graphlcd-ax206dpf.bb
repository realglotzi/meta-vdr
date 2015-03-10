SUMMARY = "VDR graphlcd plugin"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=f73069ee5fe10af114e5300a37d32d44"

SRCREV = "5b5bf594f026fbcba2e31b423b43a2e5e45fd471"
SRC_URI = "git://projects.vdr-developer.org/vdr-plugin-graphlcd.git;branch=touchcol \
          "

PR="r2"

S = "${WORKDIR}/git"

DEPENDS = " \
	graphlcd-base-ax206dpf \
	vdr \
"

CXXFLAGS_append = " -fPIC -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

EXTRA_OEMAKE = ' \
	SDKSTAGE="${STAGING_DIR_HOST}" INCLUDES=-I${STAGING_INCDIR} \
'

do_install() {
	oe_runmake DESTDIR=${D} install
}

FILES_${PN} = " \
	${libdir}/vdr/* \
	${datadir}/vdr/plugins/graphlcd/* \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"
