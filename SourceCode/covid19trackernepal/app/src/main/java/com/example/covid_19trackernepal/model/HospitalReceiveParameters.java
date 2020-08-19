package com.example.covid_19trackernepal.model;

import android.os.Parcelable;

import com.activeandroid.Model;

import java.io.Serializable;
import java.util.List;

public class HospitalReceiveParameters implements Serializable{


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * _id : 5e7cae178841fc07fcb2b96d
         * location : {"type":"Point","coordinates":[28.26689,83.96851]}
         * is_full : false
         * government_approved : false
         * name : AAMA BAA HOSPITAL AND RESEARCH CENTER
         * contact_person : Dr. Sandip Gorkhali
         * contact_person_number : 9805854242
         * address :
         * phone : 064-420250,9805854242
         * website :
         * email :
         * notes : P.P.E ,they are planning to set a room for covid-19
         * hospital_id : a281216f-5d5c-47cc-9f99-b5924518fcfd
         * state : 4
         * image_url :
         * source : Hamro LifeBank
         * capacity : {"beds":"15","ventilators":"no","isolation_beds":"","occupied_beds":"","doctors":"1","nurses":"15"}
         * created_at : 2020-03-26T13:28:55.602Z
         * updated_at : 2020-03-26T14:01:07.457Z
         * __v : 0
         */

        private String _id;
        private LocationBean location;
        private boolean is_full;
        private boolean government_approved;
        private String name;
        private String contact_person;
        private String contact_person_number;
        private String address;
        private String phone;
        private String website;
        private String email;
        private String notes;
        private String hospital_id;
        private String state;
        private String image_url;
        private String source;
        private CapacityBean capacity;
        private String created_at;
        private String updated_at;
        private int __v;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public boolean isIs_full() {
            return is_full;
        }

        public void setIs_full(boolean is_full) {
            this.is_full = is_full;
        }

        public boolean isGovernment_approved() {
            return government_approved;
        }

        public void setGovernment_approved(boolean government_approved) {
            this.government_approved = government_approved;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContact_person() {
            return contact_person;
        }

        public void setContact_person(String contact_person) {
            this.contact_person = contact_person;
        }

        public String getContact_person_number() {
            return contact_person_number;
        }

        public void setContact_person_number(String contact_person_number) {
            this.contact_person_number = contact_person_number;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getHospital_id() {
            return hospital_id;
        }

        public void setHospital_id(String hospital_id) {
            this.hospital_id = hospital_id;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public CapacityBean getCapacity() {
            return capacity;
        }

        public void setCapacity(CapacityBean capacity) {
            this.capacity = capacity;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public static class LocationBean implements  Serializable {
            /**
             * type : Point
             * coordinates : [28.26689,83.96851]
             */

            private String type;
            private List<Double> coordinates;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<Double> getCoordinates() {
                return coordinates;
            }

            public void setCoordinates(List<Double> coordinates) {
                this.coordinates = coordinates;
            }
        }

        public static class CapacityBean implements Serializable{
            /**
             * beds : 15
             * ventilators : no
             * isolation_beds :
             * occupied_beds :
             * doctors : 1
             * nurses : 15
             */

            private String beds;
            private String ventilators;
            private String isolation_beds;
            private String occupied_beds;
            private String doctors;
            private String nurses;

            public String getBeds() {
                return beds;
            }

            public void setBeds(String beds) {
                this.beds = beds;
            }

            public String getVentilators() {
                return ventilators;
            }

            public void setVentilators(String ventilators) {
                this.ventilators = ventilators;
            }

            public String getIsolation_beds() {
                return isolation_beds;
            }

            public void setIsolation_beds(String isolation_beds) {
                this.isolation_beds = isolation_beds;
            }

            public String getOccupied_beds() {
                return occupied_beds;
            }

            public void setOccupied_beds(String occupied_beds) {
                this.occupied_beds = occupied_beds;
            }

            public String getDoctors() {
                return doctors;
            }

            public void setDoctors(String doctors) {
                this.doctors = doctors;
            }

            public String getNurses() {
                return nurses;
            }

            public void setNurses(String nurses) {
                this.nurses = nurses;
            }
        }
    }
}
