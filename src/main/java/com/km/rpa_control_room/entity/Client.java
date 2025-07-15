package com.km.rpa_control_room.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(name = "name")
      private String name;

      @Column(name = "vm_address")
      private String vmAddress;

      @OneToMany(mappedBy = "client", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
                  CascadeType.REFRESH })
      private List<Bot> bots;

      public Long getId() {
            return id;
      }

      public String getName() {
            return name;
      }

      public String getVmAddress() {
            return vmAddress;
      }

      public List<Bot> getBots() {
            return bots;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public void setName(String name) {
            this.name = name;
      }

      public void setVmAddress(String vmAddress) {
            this.vmAddress = vmAddress;
      }

      public void setBots(List<Bot> bots) {
            this.bots = bots;
      }

      @Override
      public String toString() {
            return "Client [id=" + id + ", name=" + name + ", vmAddress=" + vmAddress + "]";
      }

      public void set(Bot tempBot) {

            if (bots == null) {
                  bots = new ArrayList<>();
            }

            bots.add(tempBot);

            tempBot.setClient(this);
      }
}
