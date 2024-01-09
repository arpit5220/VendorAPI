package restapi.cloudVendor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restapi.cloudVendor.exception.CloudVendorNotFoundException;
import restapi.cloudVendor.model.CloudVendor;
import restapi.cloudVendor.repository.CloudVendorRepository;
import restapi.cloudVendor.service.CloudVendorService;

import java.util.List;
@Service
public class CloudVendorServiceimpl implements CloudVendorService {

    @Autowired
    CloudVendorRepository cloudVendorRepository;
    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Deletion Success";

    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exists");

        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> getByVendorName(String vendorName) {
        return cloudVendorRepository.findByVendorName(vendorName);
    }
}
