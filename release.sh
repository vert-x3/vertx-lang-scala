#!/bin/bash

stty sane

echo
echo "==Vert.x Lang Scala Release=="
echo
echo -n "Determining project version"
GUESSED_SNAPSHOT_VERSION=$(mvn help:evaluate -Dexpression=project.version | grep -v '^\[')
echo " - found $GUESSED_SNAPSHOT_VERSION"
echo
read -p "Enter SNAPSHOT version to release: [$GUESSED_SNAPSHOT_VERSION] " SNAPSHOT_VERSION
SNAPSHOT_VERSION=${SNAPSHOT_VERSION:-$GUESSED_SNAPSHOT_VERSION}
GUESSED_RELEASE_VERSION=$(echo $SNAPSHOT_VERSION | sed -e 's/.SNAPSHOT//g')
read -p "Enter RELEASE version: [$GUESSED_RELEASE_VERSION] " RELEASE_VERSION
RELEASE_VERSION=${RELEASE_VERSION:-$GUESSED_RELEASE_VERSION}
echo
read -p "Releasing $RELEASE_VERSION - is this correct? [y|N] " CONFIRMATION
CONFIRMATION=${CONFIRMATION:-N}

if [[ $CONFIRMATION =~ [yY] ]]; then
  find . -name "pom.xml" -exec sed -i .backup "s/^  <version>$SNAPSHOT_VERSION<\/version>/  <version>$RELEASE_VERSION<\/version>/g" {} \;
  echo "Replaced $SNAPSHOT_VERSION with $RELEASE_VERSION"
  echo "Now, please commit and push."
else
  echo "Aborted."
fi
echo