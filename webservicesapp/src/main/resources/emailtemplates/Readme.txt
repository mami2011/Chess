As part of maven build process copy all the email template files from respective 
domains (registration, listing, inventory, etc...) to this folder.

The file names for now need to be unique. Later to avoid collision, we can put a 
namespace to the files.

Example: Registration.vm can be renamed to 'registration.Regitration.vm'