SUMMARY = "VDR skindesigner plugin"
LICENSE = "GPLv2" 
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRCREV = "f3ad276385796a2a848be4b280aa9a1705226f20"
SRC_URI = "git://projects.vdr-developer.org/git/vdr-plugin-skindesigner.git;protocol=http \
           file://vdr-skindesigner-fadeout.patch \            
           file://vdr-skindesigner-makefile.patch \
		   file://vdr-skindesigner-version.patch"

PR="r0"

S = "${WORKDIR}/git"

ASNEEDED = ""

DEPENDS = " \
	librsvg \
	jpeg \
	libpng  \
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
	${sysconfdir}/vdr/themes/* \
	${datadir}/vdr/plugins/skindesigner/* \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"
