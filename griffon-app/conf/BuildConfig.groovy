griffon.project.dependency.resolution = {
    // implicit variables
    // pluginName:     plugin's name
    // pluginVersion:  plugin's version
    // pluginDirPath:  plugin's install path
    // griffonVersion: current Griffon version
    // groovyVersion:  bundled groovy
    // springVersion:  bundled Spring
    // antVertsion:    bundled Ant
    // slf4jVersion:   bundled Slf4j

    // inherit Griffon' default dependencies
    inherits("global") {
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        griffonHome()
        mavenCentral()
        // pluginDirPath is only available when installed
        // String basePath = pluginDirPath? "${pluginDirPath}/" : ''
        // flatDir name: "${pluginName}LibDir", dirs: ["${basePath}lib"]
    }
    dependencies {
        compile('org.eclipse.jgit:org.eclipse.jgit:1.2.0.201112221803-r') {
            excludes 'jsch'
            exported = false
        }
        build('org.eclipse.jgit:org.eclipse.jgit:1.2.0.201112221803-r') {
            excludes 'jsch'
        }
    }
}

griffon {
    doc {
        logo = '<a href="http://griffon.codehaus.org" target="_blank"><img alt="The Griffon Framework" src="../img/griffon.png" border="0"/></a>'
        sponsorLogo = "<br/>"
        footer = "<br/><br/>Made with Griffon (@griffon.version@)"
    }
}

log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
    }

    error 'org.codehaus.griffon',
          'org.springframework',
          'org.apache.karaf',
          'groovyx.net'
    warn  'griffon'
}
