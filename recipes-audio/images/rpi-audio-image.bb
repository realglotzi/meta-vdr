include recipes-core/images/core-image-minimal.bb

IMAGE_FEATURES += "package-management ssh-server-dropbear"

IMAGE_INSTALL += "kernel-modules linux-firmware tiny-init nfs-utils esd esddsp esd-utils alsa-utils libmad lame mpd mpc rfidexec"

export IMAGE_BASENAME="rpi-audio-image"

