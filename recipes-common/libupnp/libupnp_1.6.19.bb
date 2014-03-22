DESCRIPTION = "The portable SDK for UPnP* Devices (libupnp) provides developers with an API and open source code for building control points, devices, and bridges that are compliant with Version 1.0 of the Universal Plug and Play Device Architecture Specification."
HOMEPAGE = "http://pupnp.sourceforge.net/"
LIC_FILES_CHKSUM = "file://COPYING;md5=d41d8cd98f00b204e9800998ecf8427e"
LICENSE = "BSD"

PR = "r0"

LEAD_SONAME = "libupnp"
SRC_URI = "${SOURCEFORGE_MIRROR}/pupnp/${P}.tar.bz2"

inherit autotools

SRC_URI[md5sum] = "ee16e5d33a3ea7506f38d71facc057dd"
SRC_URI[sha256sum] = "b3142b39601243b50532eec90f4a27dba85eb86f58d4b849ac94edeb29d9b22a"