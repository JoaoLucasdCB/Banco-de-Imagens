// This file contains JavaScript functions to interact with the API, including:
// - addImage: Sends a POST request to add a new image.
// - fetchImages: Sends a GET request to retrieve the list of images.
// - deleteImage: Sends a DELETE request to remove an image.
// - updateImage: Sends a PUT request to edit an image.
// - updateGallery: Updates the gallery dynamically after each action.

const apiUrl = '/api/images';

async function addImage(event) {
    event.preventDefault();
    const name = document.getElementById('imageName').value;
    const url = document.getElementById('imageUrl').value;

    const response = await fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, url }),
    });

    if (response.ok) {
        updateGallery();
    } else {
        console.error('Failed to add image');
    }
}

async function fetchImages() {
    const response = await fetch(apiUrl);
    if (response.ok) {
        const images = await response.json();
        return images;
    } else {
        console.error('Failed to fetch images');
        return [];
    }
}

async function deleteImage(id) {
    const response = await fetch(`${apiUrl}/${id}`, {
        method: 'DELETE',
    });

    if (response.ok) {
        updateGallery();
    } else {
        console.error('Failed to delete image');
    }
}

async function updateImage(id) {
    const name = document.getElementById(`imageName-${id}`).value;
    const url = document.getElementById(`imageUrl-${id}`).value;

    const response = await fetch(`${apiUrl}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, url }),
    });

    if (response.ok) {
        updateGallery();
    } else {
        console.error('Failed to update image');
    }
}

async function updateGallery() {
    const gallery = document.getElementById('gallery');
    gallery.innerHTML = '';

    const images = await fetchImages();
    images.forEach(image => {
        const imageElement = document.createElement('div');
        imageElement.innerHTML = `
            <h3>${image.name}</h3>
            <img src="${image.url}" alt="${image.name}" />
            <button onclick="deleteImage(${image.id})">Remove</button>
            <input type="text" id="imageName-${image.id}" value="${image.name}" />
            <input type="text" id="imageUrl-${image.id}" value="${image.url}" />
            <button onclick="updateImage(${image.id})">Update</button>
        `;
        gallery.appendChild(imageElement);
    });
}

document.getElementById('imageForm').addEventListener('submit', addImage);
window.onload = updateGallery;