SUMMARY = "VDR HD output device for Raspberry Pi"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"
COMPATIBLE_MACHINE = "raspberrypi"

SRCREV = "beb7667ab18ee5231f5d0da1c30b02addafae57e"
SRC_URI = "git://projects.vdr-developer.org/vdr-plugin-rpihddevice.git"

PR="r6"

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

CXXFLAGS_append = " -fPIC "

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

