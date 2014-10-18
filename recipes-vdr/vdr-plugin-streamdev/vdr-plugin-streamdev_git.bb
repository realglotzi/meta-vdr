SUMMARY = "VDR streamdev plugin"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCREV = "e8629b5ec6e34abbb8b6dc3e487d65d1c2b1d547"
SRC_URI = "git://projects.vdr-developer.org/vdr-plugin-streamdev.git"

#SRC_URI += " \
#	file://rpihddevice-opt-vc.diff \
#"

PR="r0"

S = "${WORKDIR}/git"

ASNEEDED = ""

DEPENDS = " \
	vdr \
"

EXTRA_OEMAKE = ' \
	SDKSTAGE="${STAGING_DIR_HOST}" \
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
