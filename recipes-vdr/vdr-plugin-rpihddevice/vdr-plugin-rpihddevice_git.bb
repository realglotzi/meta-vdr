SUMMARY = "VDR HD output device for Raspberry Pi"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"
COMPATIBLE_MACHINE = "(raspberrypi|raspberrypi2)"

SRCREV = "f4b9c55f3e4eb6e60aceba43d97f611020dc0361"
SRC_URI = "git://projects.vdr-developer.org/vdr-plugin-rpihddevice.git"

PR="r19"

SRC_URI += " \
	file://rpihddevice-opt-vc.diff \
"

S = "${WORKDIR}/git"

ASNEEDED = ""

DEPENDS = " \
	vdr \
	ffmpeg \
	freetype \
	virtual/libgl \
	virtual/libgles2 \
	virtual/egl \
"

CXXFLAGS_append = " -fPIC -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

EXTRA_OEMAKE = ' \
	SDKSTAGE="${STAGING_DIR_HOST}" \
'

do_install() {
	oe_runmake DESTDIR=${D} install
}

FILES_${PN} += " \
	${libdir}/vdr/* \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"

