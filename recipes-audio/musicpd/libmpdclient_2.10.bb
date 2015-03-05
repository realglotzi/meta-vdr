DESCRIPTION = "Music Player Daemon client library"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=06b9dfd2f197dc514d8ef06549684b77"
HOMEPAGE ="http://sourceforge.net/projects/musicpd"
DEPENDS = "glib-2.0"

SRC_URI = "http://www.musicpd.org/download/${PN}/2/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "8aef1e9a3dcb4ed0f1387e5d774b02bc"
SRC_URI[sha256sum] = "bf88ddd9beceadef11144811adaabe45008005af02373595daa03446e6b1bf3d"

inherit autotools

FILES_${PN}-dbg += " /usr/share/vala/* \
					 /usr/share/vala/vapi/* \
					 /usr/share/vala/vapi/libmpdclient.vapi"
