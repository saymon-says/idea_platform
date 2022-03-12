.PHONY: build

install:
	gradlew clean install

run-dist:
	build\install\idea_platform\bin\idea_platform
check-updates:
	gradlew dependencyUpdates

build:
	gradlew clean build
